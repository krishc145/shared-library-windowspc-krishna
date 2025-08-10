// vars/PushToArtifactory.groovy
def call(String artifactoryUrl, String repo, String artifactPath, String targetPath, String jfrogCliPath = 'jfrog') {
    if (!artifactoryUrl || !repo || !artifactPath || !targetPath) {
        error "PushToArtifactory: All parameters (artifactoryUrl, repo, artifactPath, targetPath) must be provided"
    }

    // Configure Artifactory server (only once needed, consider moving to global config)
    sh "${jfrogCliPath} rt config --url=${artifactoryUrl} --interactive=false"

    // Upload artifact to Artifactory repo
    sh "${jfrogCliPath} rt upload '${artifactPath}' '${repo}/${targetPath}'"
}
