# Demonstration of an unsuccessful communication between plugins

This repository was set up to ask for help with cross-plugin communication.

# How to setup

```
# With Java 17
# With Maven 3.9.9
mvn install
```
It will produce 2 plugins that you can install in Confluence.

# Checking it works

Each plugin should say its name:
* http://c9.4.0.local:2013/c-app/rest/plugin-a/1/info ( :white_check_mark: Works)
* http://c9.4.0.local:2013/c-app/rest/plugin-b/1/info ( :x: Doesn't work)

Usecases:

* http://c9.4.0.local:2013/c-app/rest/plugin-a/1/magic/1 Injecting a component directly:
  * ComponentA is injected in the constructor of the REST API,
  * REST API answers "Component A" ( :white_check_mark: Works)
* http://c9.4.0.local:2013/c-app/rest/plugin-a/1/magic/2 Using the PluginAccessor ( :x: Doesn't work):
  * The REST API uses `pluginAccessor.getEnabledModulesByClass(ComponentA.class)`,
  * It should return "Component A" ( :x: Doesn't work),
* http://c9.4.0.local:2013/c-app/rest/plugin-a/1/magic/3 Using the PluginAccessor for an interface ( :x: Doesn't work):
  * The REST API uses `pluginAccessor.getEnabledModulesByClass(MyInterface.class)`,
  * ComponentA implements MyInterface so it should be returned,
  * It should return "Component A" ( :x: Doesn't work),

# Communicating across plugins

* Plugin B has ComponentB.java, which implements MyInterface.class from Plugin A,
* Plugin B imports the package of MyInterface using a `<DynamicImport-Package>`,
* Plugin A exports this package using `<Export-Package>`,
* Plugin A's REST API queries all components implementing MyInterface. It should return ComponentA and ComponentB,
* But it returns neither of them at http://c9.4.0.local:2013/c-app/rest/plugin-a/1/magic/3 ( :x: Doesn't work)