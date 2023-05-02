To launch the prototype, run 'mvn gwt:run' or 'mvn gwt:debug'.
No database or other configuration is needed, the proto use an in-memory database that is 
automatically initialized on launch.

To log in, use any username, but the password must be manager

pour lancer :
 mvn gwt:run -Pdev

pour lancer avec saml :
  SPRING_PROFILES_ACTIVE=securitySaml mvn gwt:run -Pdev
