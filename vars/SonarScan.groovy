// vars/SonarScan.groovy
def call(String scannerHome = 'SONAR_SCANNER_HOME', String projectKey = null, String projectName = null, String sources = 'src') {
    if (!projectKey || !projectName) {
        error "SonarScan: projectKey and projectName parameters are required!"
    }

    withSonarQubeEnv('SonarQube') {  // 'SonarQube' is the name of your SonarQube server configured in Jenkins
        sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=${projectKey} \
            -Dsonar.projectName=${projectName} \
            -Dsonar.sources=${sources}
        """
    }
}
