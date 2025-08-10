// vars/DeployToMinikube.groovy
def call(String manifestPath) {
    if (!manifestPath) {
        error "DeployToMinikube: manifestPath parameter is required!"
    }
    
    echo "Deploying to Minikube using manifest: ${manifestPath}"
    
    // Apply the Kubernetes manifest using kubectl
    sh "kubectl apply -f ${manifestPath}"
    
    echo "Deployment to Minikube completed."
}
