#!/bin/bash

# API Endpoints
HOSPITAL_URL="http://localhost:8086/Hospital/Register"
DOCTOR_URL="http://localhost:8086/Hospital/AddDoctor"
STATUS_URL="http://localhost:8086/Hospital/setStatus"

# Sample hospital data (name|city|type|speciality|icu_available|ot_available|address|password|contact)
declare -a HOSPITALS=(
    "Parbhani Care Hospital|Parbhani|General|Multispeciality|true|true|123street|parbhani123|9876543210"
    "Aurangabad Medical Center|Aurangabad|Trauma|Neuro|true|false|Main Road|aurangabad456|9823456780"
    "Nanded Superspeciality|Nanded|Cardiac|Heart|true|true|Station Road|nanded789|9898989898"
    "Latur HealthPoint|Latur|Orthopedic|Bone|false|true|Shahu Chowk|latur321|9988776655"
    "Beed Surgical Clinic|Beed|Surgical|General|true|false|College Road|beed654|9765432101"
    "Latur City Hospital|Latur|General|Multispeciality|true|true|VIP Road|laturpass1|9856123470"
    "Shivani Children's Hospital|Latur|Pediatric|Children|false|true|Nandi Stop|shivani789|9845672301"
    "Sanjeevani Hospital|Latur|Cardiac|Cardiology|true|false|Main Road|sanj321|9876543280"
    "Siddhivinayak Hospital|Latur|Orthopedic|Bone|true|true|MG Road|siddhi123|9812345678"
    "Omega Multispeciality|Latur|Multispeciality|ENT|true|true|Renapur Road|omega456|9988776611"
    "Latur Women's Hospital|Latur|Gynecology|Women|false|false|Udyog Bhavan|womenpass|9898981212"
    "Latur Trauma Center|Latur|Emergency|Trauma|true|true|Barshi Road|traumapass|9867543210"
    "City Eye Care|Latur|Eye|Ophthalmology|false|false|Shivaji Chowk|eyepass|9876512345"
    "Latur ENT Center|Latur|ENT|Ear/Nose|false|true|MG Complex|entpass|9811223344"
    "Shree Krishna Hospital|Latur|General|Multispeciality|true|true|Railway Station Rd|krishna123|9123456789"
    "Jalna Heart Clinic|Jalna|Cardiology|Heart|true|false|Central Market|jalna321|9812349812"
    "Osmanabad Ortho Care|Osmanabad|Orthopedic|Bone|false|true|Old Bus Stop|osman456|9834561230"
    "Hingoli Health Center|Hingoli|General|Family|true|true|Civil Lines|hingoli789|9873214560"
    "Ambajogai Medical|Ambajogai|Surgical|General|false|true|Ambedkar Chowk|amba111|9865423100"
    "Udgir City Clinic|Udgir|Multispeciality|ENT|true|false|Station Road|udgir321|9870001112"
)

# Register hospitals
i=1
for hospital in "${HOSPITALS[@]}"; do
    IFS="|" read -r name city type speciality icu_available ot_available address password contact <<< "$hospital"

    curl -s -X POST "$HOSPITAL_URL" \
        -H "Content-Type: application/x-www-form-urlencoded" \
        -d "name=$name" \
        -d "city=$city" \
        -d "type=$type" \
        -d "speciality=$speciality" \
        -d "icu_available=$icu_available" \
        -d "ot_available=$ot_available" \
        -d "address=$address" \
        -d "password=$password" \
        -d "contact=$contact"

    echo "[$i] Registered Hospital: $name"
    ((i++))
done

# Sample doctor data (name|speciality|contact|degree|hospitalId)
declare -a DOCTORS=(
    "Dr. A K Singh|Cardiology|9876512345|MD|1"
    "Dr. R Patel|Orthopedic|9823467890|MS|2"
    "Dr. Meena Joshi|ENT|9876543212|MBBS|3"
    "Dr. Rajiv Rao|Neuro|9812345678|DM|4"
    "Dr. S K Kulkarni|Gynecology|9871234567|MD|5"
)

# Add doctors
for doctor in "${DOCTORS[@]}"; do
    IFS="|" read -r name speciality contact degree hospitalId <<< "$doctor"

    curl -s -X POST "$DOCTOR_URL" \
        -H "Content-Type: application/x-www-form-urlencoded" \
        -d "name=$name" \
        -d "speciality=$speciality" \
        -d "contact=$contact" \
        -d "degree=$degree" \
        -d "hospital_id=$hospitalId"

    echo "Added Doctor: $name"
done

# Sample status data (hospitalId|icu_available|ot_active|status|presentDoctor|staffCount|ambulanceCount)
declare -a STATUSES=(
    "1|true|true|open|Dr. A K Singh|35|2"
    "2|true|false|open|Dr. R Patel|25|1"
    "3|false|true|close|Dr. Meena Joshi|20|0"
    "4|true|true|open|Dr. Rajiv Rao|30|3"
    "5|true|false|close|Dr. S K Kulkarni|22|1"
    "6|true|true|open|Dr. A K Singh|26|1"
    "7|false|true|open|Dr. R Patel|18|0"
    "8|true|false|open|Dr. Meena Joshi|28|2"
    "9|true|true|open|Dr. Rajiv Rao|40|3"
    "10|true|true|open|Dr. S K Kulkarni|32|1"
)

# Set hospital statuses
for status in "${STATUSES[@]}"; do
    IFS="|" read -r hospitalId icu_available ot_active statusVal presentDoctor staffCount ambulanceCount <<< "$status"

    curl -s -X POST "$STATUS_URL" \
        -H "Content-Type: application/x-www-form-urlencoded" \
        -d "hospital_id=$hospitalId" \
        -d "icu_available=$icu_available" \
        -d "ot_active=$ot_active" \
        -d "status=$statusVal" \
        -d "presentDoctor=$presentDoctor" \
        -d "staffCount=$staffCount" \
        -d "ambulanceCount=$ambulanceCount"

    echo "Set Status for Hospital ID $hospitalId"
done
