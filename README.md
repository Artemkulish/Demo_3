# Deploy of multi-service Java application

# Infrastructure
![1](https://user-images.githubusercontent.com/57228865/79222403-20c59000-7e60-11ea-838c-e148d5fbe1be.jpg)

GitLab configuration:
- Create instance with at least 8GB RAM (16GB is preferable)
- Install GitLab: https://about.gitlab.com/install/
- Install GitLab Runner: https://docs.gitlab.com/runner/install/linux-manually.html
- Register **shell** runner: https://docs.gitlab.com/runner/register/
- Connect GitHub with GitLab: https://docs.gitlab.com/ee/ci/ci_cd_for_external_repos/github_integration.html
- Add necessary environment variables https://docs.gitlab.com/ee/ci/variables/README.html#via-the-ui
- Install Java: https://java.com/en/download/help/download_options.xml
- Install Maven: https://maven.apache.org/install.html
- Install Liquibase: https://www.liquibase.org/get_started/lb-setup-tutorial.html
