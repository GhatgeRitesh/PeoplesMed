#!/bin/bash

URL="http://localhost:8086/Hospital/Register"

declare -a HOSPITALS=(
    "Parbhani Care Hospital|Parbhani|General|Multispeciality|true|true|123street|parbhani123"
    "Aurangabad Medical Center|Aurangabad|Trauma|Neuro|true|false|main road|aurangabad456"
    "Nanded Superspeciality|Nanded|Cardiac|Heart|true|true|station road|nanded789"
    "Latur HealthPoint|Latur|Orthopedic|Bone|false|true|shahu chowk|latur321"
    "Beed Surgical Clinic|Beed|Surgical|General|true|false|college road|beed654"
    "Latur City Hospital|Latur|General|Multispeciality|true|true|VIP Road|laturpass1"
    "Shivani Children's Hospital|Latur|Pediatric|Children|false|true|Nandi Stop|shivani789"
    "Sanjeevani Hospital|Latur|Cardiac|Cardiology|true|false|Main Road|sanj321"
    "Siddhivinayak Hospital|Latur|Orthopedic|Bone|true|true|MG Road|siddhi123"
    "Omega Multispeciality|Latur|Multispeciality|ENT|true|true|Renapur Road|omega456"
    "Latur Women's Hospital|Latur|Gynecology|Women|false|false|Udyog Bhavan|womenpass"
    "Latur Trauma Center|Latur|Emergency|Trauma|true|true|Barshi Road|traumapass"
    "City Eye Care|Latur|Eye|Ophthalmology|false|false|Shivaji Chowk|eyepass"
    "Latur ENT Center|Latur|ENT|Ear/Nose|false|true|MG Complex|entpass"
    "Shree Krishna Hospital|Latur|General|Multispeciality|true|true|Railway Station Rd|krishna123"
    "Jalna Heart Clinic|Jalna|Cardiology|Heart|true|false|Central Market|jalna321"
    "Osmanabad Ortho Care|Osmanabad|Orthopedic|Bone|false|true|Old Bus Stop|osman456"
    "Hingoli Health Center|Hingoli|General|Family|true|true|Civil Lines|hingoli789"
    "Ambajogai Medical|Ambajogai|Surgical|General|false|true|Ambedkar Chowk|amba111"
    "Udgir City Clinic|Udgir|Multispeciality|ENT|true|false|Station Road|udgir321"
    "Georai Hospital|Georai|Emergency|Trauma|true|true|Main Bazaar|georai123"
    "Majalgaon Medicare|Majalgaon|General|Family|false|true|Gandhi Square|majalgaon456"
    "Pathri Wellness Center|Pathri|Ayurvedic|Natural|false|false|Green Lane|pathri789"
    "Ahmedpur LifeCare|Ahmedpur|General|General|true|false|Shivaji Nagar|ahmedpass"
    "Murud Specialty Hospital|Murud|Multispeciality|Neuro|true|true|Hill View|murud456"
    "Renapur Children's Clinic|Renapur|Pediatric|Children|true|false|Post Office Rd|renachild"
    "Nilanga General Hospital|Nilanga|General|Family|true|true|Station Bazaar|nilanga123"
    "Kaij Hospital|Kaij|General|Women|false|false|Old Market|kaij789"
    "Partur Superspeciality|Partur|Multispeciality|ENT|true|true|Bus Depot|partur321"
    "Manwath Medical Center|Manwath|Cardiac|Heart|true|false|Main Lane|manwath456"
)

for hospital in "${HOSPITALS[@]}"; do
    IFS="|" read -r name city type speciality icu_available ot_available address password <<< "$hospital"

    curl -X POST "$URL" \
        -H "Content-Type: application/x-www-form-urlencoded" \
        -d "name=$name" \
        -d "city=$city" \
        -d "type=$type" \
        -d "speciality=$speciality" \
        -d "icu_available=$icu_available" \
        -d "ot_available=$ot_available" \
        -d "address=$address" \
        -d "password=$password"

    echo -e "\nSubmitted: $name"
done