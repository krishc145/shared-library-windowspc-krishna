// vars/DockerImage.groovy
def call(String dockerfile = 'Dockerfile', String imageName, String tag = 'latest', String registry = null) {
    if (!imageName) {
        error "DockerImage: imageName parameter is required!"
    }

    def fullImageName = registry ? "${registry}/${imageName}:${tag}" : "${imageName}:${tag}"

    echo "Building Docker image: ${fullImageName}"

    sh "docker build -f ${dockerfile} -t ${fullImageName} ."

    echo "Docker image built: ${fullImageName}"

    if (registry) {
        echo "Pushing Docker image to registry: ${fullImageName}"
        sh "docker push ${fullImageName}"
    } else {
        echo "No registry provided, skipping docker push."
    }
}
