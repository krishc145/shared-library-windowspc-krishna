// vars/MavenBuild.groovy
def call(String goals = 'clean install', String mavenHome = '') {
    if (!mavenHome) {
        // If mavenHome is not passed, try to use the default tool configured in Jenkins
        mavenHome = tool name: 'Maven', type: 'maven'
    }

    withEnv(["PATH+MAVEN=${mavenHome}/bin"]) {
        sh "mvn ${goals}"
    }
}
