// vars/Email.groovy
def call(String subject, String body, String recipients) {
    if (!subject || !body || !recipients) {
        error "Email: subject, body, and recipients parameters are required!"
    }

    emailext(
        subject: subject,
        body: body,
        to: recipients
    )
}
