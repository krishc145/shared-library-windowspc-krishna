// vars/DeployToOpenshift.groovy
def call(String manifestPath, String project = null) {
    if (!manifestPath) {
        error "DeployToOpenshift: manifestPath parameter is required!"
    }

    if (project) {
        echo "Switching to OpenShift project: ${project}"
        sh "oc project ${project}"
    }

    echo "Deploying to OpenShift using manifest: ${manifestPath}"

    // Apply the OpenShift manifest using oc
    sh "oc apply -f ${manifestPath}"

    echo "Deployment to OpenShift completed."
}
