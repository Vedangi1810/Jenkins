

jenkins-master : jenkins should be installed
jenkins-agent : jdk should be installed

Jenkins Agent:

Create agent on UI

Run this command:
    C:\Users\New>curl.exe -sO http://localhost:8080/jnlpJars/agent.jar & java -jar agent.jar -url http://localhost:8080/ -secret af7bcaf5ab8b4a2a92906367f29aa2447275b2eb30b6c6d76ef2e904a2bbea44 -name "jenkins-agent" -webSocket -workDir "C:\jenkins-agent"

Configure DemoCICD job and modify to use: agent {label 'veda'}

Check output: (job executing on agent node)
    C:\jenkins-agent\workspace\DemoCICD\devops-jenkins