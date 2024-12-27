job('First-Maven-Project-Via-DSL'){
    description ("First Maven job generated bu the DSL on ${new Date()},
    the project  is a samll Maven Project hosted on github")
    //Source code management
    scm{
        git("https://github.com/code9633/MavenProject.git", master)
    }
    triggers{
        scm('* * * * *') // every minute triggered
    }
    steps{
        maven('clean package', 'Single_module/pom.xml')
    }
    publishers{
        // archive the war file generated
        archiveArtifacts '**/*.jar'
    }
}