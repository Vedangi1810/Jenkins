Declarative Pipeline Demo:

Manage Jenkins --> Plugins --> Pipeline: stage view - Install

Credentials:

manage jenkins --> credentials --> store scopred to jenkins - Global (add)
username, password (token), id, description
modify groovy script
============================================================================
Github WebHook:

Cofiguration on Github:
    Fork the repo
    setting of repo
    webhooks: Add webhook
        payload url: http://localhost:8080/github-webhook/
        content: application/x-www-form-urlencoded
        ssl: disable
        event: send me everything
        active
        
Configuration on Jenkins:
    DjangoCICD
        Configure
            Build Triggers: Github hook trigger for GITScm polling
============================================================================

Shared Libraries:
Repo -> groovy code -> Reuse (pipeline)
Github - Repo - New Repo - jenkins-shared-libraries
    vars/ - hello.groovy

Manage jenkins -> system -> serach "libraries" - Global Trusted Pipeline Libraries
    Library
    Name: Shared
    Default version: main
    allow default version ...
    include @Libraru changes ...
    Retrival method: modern scm
        Git
            proj url: "https://github.com/Vedangi1810/jenkins-shared-libraries.git"

Update in DjangoCICD pipeline - configure - code = add @Library at the top

Update all .groovy for all stages

Jenkinsfile:
    pipeline script can be added in github and add that url in Pipeline from SCM
==================================================================================

User Management in Jenkins

manage jenkins --> Users --> create user
    Plugins - available plugins - Role-based AUthorization strategy (Install)

Manage jenkins --> security --> 
    Authorization : Role-based strategy
Manage jenkins --> security --> Manage and Assign Roles 
    Manage roles: Role to add: viewer
    Assign roles: select name (authenticated user) and viewer
==================================================================================
