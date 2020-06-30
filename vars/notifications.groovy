#!/usr/bin/env groovy
import groovy.json.JsonOutput

def call(text, channel, urlSlack, attachements) {
    def slackURL = urlSlack
    def jenkinsIcon = 'https://wiki.jenkins-ci.org/download/attachments/2916393/logo.png'

    def payload = JsonOutput.toJson([text: text,
        channel: channel,
        username: "Jenkins",
        icon_url: jenkinsIcon,
        attachement: attachements
    ])

    sh "curl -X POST --data-urlencode \'payload=${payload}\' ${slackURL}"
}