#!/bin/sh

set -e

echo "Creating Docker images for the services..."

# Define arrays properly
FilePaths=( "./CustomerService" "./DatabaseService" "./Emergency-Service" "./HospitalService" "./NotificationService" "./PaymentService" "./RegistryService" )
ImageNames=( "customer-service-image" "database-service-image" "emergency-service-image" "hospital-service-image" "notification-service-image" "payment-service-image" "registry-service-image" )

# Loop over indices
for i in "${!FilePaths[@]}"; do
  path="${FilePaths[$i]}"
  image="${ImageNames[$i]}"

  echo "🔧 Building Docker image for: $path"
  docker build -t "$image" "$path"
  echo "✅ Successfully built image: $image"
done

echo "🎉 All Docker images built successfully."
