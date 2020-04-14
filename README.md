# Deploy of multi-service Java application

# Components
- Applications: **identity**, **messaging**, **payment**, **simulation**, **trip**, **vehicle**;
- DB update: **change logs** and the **property file**;
- CI/CD: the **.gitlab-ci.yml** script for GitLab;
- Deploy: **deploy.sh** and **docker-compose.yml**.

# Infrastructure
![1](https://user-images.githubusercontent.com/57228865/79222403-20c59000-7e60-11ea-838c-e148d5fbe1be.jpg)

# Requirements
- Minimization of external IP addresses;
- External monitoring of all services in a particular region;
- Alerting in case of emergency;
- Logs aggregation to be able to create statistics via various metrics;
- The least possible downtime during the updates.


# Google Cloud Platform
- Reserve two static IP addresses for GitLab and Load Balancer: https://cloud.google.com/compute/docs/ip-addresses/reserve-static-external-ip-address
- Configure firewall rules in order to open the ports in the range: 8080-8084: https://cloud.google.com/filestore/docs/configuring-firewall
- Create instance, router, and CloudNAT: https://github.com/Artemkulish/Ansible/blob/master/demo3/create_conteiner-opt.yml
- Create Load Balancer: https://github.com/Artemkulish/Ansible/blob/master/demo3/loadbalancer.yml
- Create CloudSQL: https://github.com/Artemkulish/Ansible/blob/master/demo3/cloudsql.yml

**GitLab configuration:**
- Create instance with at least 8GB RAM (16GB is preferable)
- Install GitLab: https://about.gitlab.com/install/
- Install GitLab Runner: https://docs.gitlab.com/runner/install/linux-manually.html
- Register **shell** Runner: https://docs.gitlab.com/runner/register/
- Connect GitHub with GitLab: https://docs.gitlab.com/ee/ci/ci_cd_for_external_repos/github_integration.html
- Add necessary environment variables https://docs.gitlab.com/ee/ci/variables/README.html#via-the-ui
- Install Java: https://java.com/en/download/help/download_options.xml
- Install Maven: https://maven.apache.org/install.html
- Install Liquibase: https://www.liquibase.org/get_started/lb-setup-tutorial.html
- Install Ansible: https://docs.ansible.com/ansible/latest/installation_guide/intro_installation.html
