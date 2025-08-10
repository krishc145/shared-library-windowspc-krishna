def call(String gitUrl = null, String branch = 'master') {
    if (gitUrl == null) {
        error "gitCheckout: Git URL must be provided!"
    }

    checkout([
        $class: 'GitSCM',
        branches: [[name: "*/${branch}"]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        userRemoteConfigs: [[url: gitUrl]]
    ])
}

