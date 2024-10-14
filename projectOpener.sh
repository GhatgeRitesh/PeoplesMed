
# Open the first Git Bash terminal, navigate to the first folder, and execute mvn spring-boot:run
start "" "C:\Program Files\Git\git-bash.exe" --cd="/D/PeoplesMed/Eureka-Server" -c "mvn spring-boot:run; exec bash"

# Open the second Git Bash terminal, navigate to the second folder, and execute mvn spring-boot:run
start "" "C:\Program Files\Git\git-bash.exe" --cd="/PeoplesMedDB" -c "mvn spring-boot:run; exec bash"

# Open the third Git Bash terminal, navigate to the third folder, and execute mvn spring-boot:run
start "" "C:\Program Files\Git\git-bash.exe" --cd="/Features" -c "mvn spring-boot:run; exec bash"

start "" "C:\Program Files\Git\git-bash.exe" --cd="/Web-Interface" -c "mvn spring-boot:run exec bash"
