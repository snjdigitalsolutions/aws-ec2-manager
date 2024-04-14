# AWS EC2 Manager
The EC2 manager is a Java based program for starting and stopping EC2 instances running
on AWS. This program is intended to reduce the cost of EC2 infrastructure which
may is not needed 24 hours a day.

Place the application configuration in /etc/ec2manager/ec2manager.conf

```bash
# Instance IP | Start time | Stop time | Region
10.24.2.98 | 0600 | 1800 | us-east-2
```

When the application is started, the configuration is read and a task scheduled
for each configuration entry. A start task and stop task is created based on the
time in the configuration.