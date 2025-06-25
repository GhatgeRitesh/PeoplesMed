@echo off
setlocal

set "BASE_DIR=D:\PeoplesMed"
set "SPRING_PROFILE=dev"

echo Launching all services in Windows Terminal tabs...

wt `
    new-tab cmd /k "cd /d %BASE_DIR%\RegisteryService && set SPRING_PROFILES_ACTIVE=%SPRING_PROFILE% && mvn spring-boot:run" ; `
    split-pane -H cmd /k "cd /d %BASE_DIR%\CustomerService && set SPRING_PROFILES_ACTIVE=%SPRING_PROFILE% && mvn spring-boot:run" ; `
    split-pane -V cmd /k "cd /d %BASE_DIR%\DatabaseService && set SPRING_PROFILES_ACTIVE=%SPRING_PROFILE% && mvn spring-boot:run" ; `
    new-tab cmd /k "cd /d %BASE_DIR%\Emergency-Servcice && set SPRING_PROFILES_ACTIVE=%SPRING_PROFILE% && mvn spring-boot:run" ; `
    split-pane -H cmd /k "cd /d %BASE_DIR%\HospitalService && set SPRING_PROFILES_ACTIVE=%SPRING_PROFILE% && mvn spring-boot:run" ; `
    split-pane -V cmd /k "cd /d %BASE_DIR%\NotificationService && set SPRING_PROFILES_ACTIVE=%SPRING_PROFILE% && mvn spring-boot:run" ; `
    new-tab cmd /k "cd /d %BASE_DIR%\PaymentService && set SPRING_PROFILES_ACTIVE=%SPRING_PROFILE% && mvn spring-boot:run"
