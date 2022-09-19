pipeline {
       agent any
       tools {
           maven 'MAVEN_HOME'
           jdk 'JAVA_HOME'
       }
       environment {
           API_KEY = credentials('CALLIOPE_API_KEY')
           PROFILE_ID = credentials('CALLIOPE_PROFILE_ID')
       }
       stages {
           stage("Tools initialization") {
               steps {
                   sh "mvn --version"
                   sh "java -version"
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'main',
                       url: "https://github.com/PriyaSahu06/validateUIAPI.git"
               }
           }
           stage("Cleaning workspace") {
               steps {
                   sh "mvn clean"
               }
           }
           stage("Running Testcase") {
              steps {
                   sh "mvn test"
               }
           }

            stage('upload') {
                   steps {
                       sh 'curl -X POST ' +
                          '-H "x-api-key:${API_KEY}" ' +
                          '-H "multipart/form-data" '+
                          '-F "file[]=@report/reports.json" ' +
                              '"https://app.calliope.pro/api/v2/profile/${PROFILE_ID}/import?tag[]=UIAPI&tag[]=SpriteCloud:Assessment&tag[]=build:1.0"'
                   }
            }

       }
 }