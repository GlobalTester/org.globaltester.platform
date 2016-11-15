node {
  stage 'Checkout project'
  PROJECT_NAME = env.JOB_NAME.split("/")[0]
  checkout([$class: 'GitSCM', 
    branches: [[name: "${env.BRANCH_NAME}"]],
    doGenerateSubmoduleConfigurations: false,
    extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "${PROJECT_NAME}"]],
    submoduleCfg: [],
    userRemoteConfigs: [[credentialsId: 'ccaa54ad-8940-4687-aebf-64979d3094fb', url: "git@git.globaltester.org:${PROJECT_NAME}"]]
  ])
  
  stage 'Checkout dependencies'
  repoList = sh returnStdout: true, script: "cat ${PROJECT_NAME}/${PROJECT_NAME}.releng/pom.xml | grep '<module>' | sed -e 's|.*\\.\\.\\/\\.\\.\\/\\([^/]*\\)\\/.*<\\/module>.*|\\1|' | sort -u"

  def repos = repoList.readLines()

  for (String curRepo : repos) {
    echo curRepo

    checkout([$class: 'GitSCM', 
      branches: [[name: "${env.BRANCH_NAME}"]],
      doGenerateSubmoduleConfigurations: false,
      extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "${curRepo}"]],
      submoduleCfg: [],
      userRemoteConfigs: [[credentialsId: 'ccaa54ad-8940-4687-aebf-64979d3094fb', url: "git@git.globaltester.org:${curRepo}"]]
    ])

  }


  stage 'Build'
  def mvnHome = tool 'M305'
  def BUILDDIR = sh returnStdout: true, script: 'mktemp -d'
  BUILDDIR = BUILDDIR.trim()
  sh "mv * ${BUILDDIR}"
  wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
    sh "cd ${BUILDDIR}/${PROJECT_NAME}/${PROJECT_NAME}.releng/ && ${mvnHome}/bin/mvn -Dmaven.test.failure.ignore clean verify"
  }
  sh "mv ${BUILDDIR}/* ."
  sh "rm -r ${BUILDDIR}"

  stage "Collect test results"
  junit '**/TEST*.xml'

}
