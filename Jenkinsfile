node {
  stage 'Checkout'
  def repos = [
   "org.globaltester.base",
   "org.globaltester.cryptoprovider",
   "org.globaltester.lib.domparser",
   "org.globaltester.lib.jmockit",
   "org.globaltester.parent"
  ]
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


String fileContents = new File(env.build.workspace.toString() + 'org.globaltester.platform/org.globaltester.platform.releng/pom.xml').text
echo fileContents



/*
  stage 'Build'
  def mvnHome = tool 'M305'
  sh "cd org.globaltester.base/org.globaltester.base.releng/ && ${mvnHome}/bin/mvn -Dmaven.test.failure.ignore clean verify"
*/
}
