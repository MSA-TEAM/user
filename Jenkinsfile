node {

    stage ('Checkout') {
        checkout([$class: 'GitSCM',
            branches: [[name: '*/master']],
            doGenerateSubmoduleConfigurations: false, extensions: [],
            submoduleCfg: [],
            userRemoteConfigs: [[credentialsId: 'DevPro', url: 'https://devpro.ktds.co.kr/msa/user.git']]])
    }


    stage ('Script'){
        sh 'ssh ec2-user@172.31.7.77 "mkdir -p /home/ec2-user/user/log"'
        sh 'scp ./start.sh ec2-user@172.31.7.77:/home/ec2-user/user'
        sh 'scp ./shutdown.sh ec2-user@172.31.7.77:/home/ec2-user/user'
        sh 'ssh ec2-user@172.31.7.77 "chmod a+x /home/ec2-user/user/*.sh"'
    }

    stage ('Shutdown Server'){
        sh 'ssh ec2-user@172.31.7.77 "/home/ec2-user/user/shutdown.sh || true"'
    }

    stage ('Build') {
        sh './gradlew clean build'
    }

    stage ('Distribution') {
        sh 'scp build/libs/user-1.0.0-RELEASE.jar ec2-user@172.31.7.77:/home/ec2-user/user'
    }

    stage ('Start Server') {
        sh 'ssh ec2-user@172.31.7.77 "/home/ec2-user/user/start.sh /home/ec2-user/user/user-1.0.0-RELEASE.jar prd"'
    }

}