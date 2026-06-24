# SmartRide Connect – Ride Booking Backend System

## Project Overview

SmartRide Connect is a Spring Boot-based Ride Booking Backend Application that allows riders to request rides, drivers to accept rides, and the system to manage the complete ride lifecycle.

The application follows a layered architecture using Controller, Service, Repository, DTO, Entity, and Exception Handling layers.

---

## Features

- Rider Registration
- Driver Registration
- Automatic Driver Assignment
- Ride Request Creation
- Ride Status Management
- Ride History Tracking
- Global Exception Handling
- DTO-Based API Design

---

## Technology Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Postman

---

## Project Structure

```text
src/main/java
│
├── controller
│   ├── RiderController
│   ├── DriverController
│   └── RideController
│
├── service
│   ├── RiderService
│   ├── DriverService
│   └── RideService
│
├── repository
│   ├── RiderRepository
│   ├── DriverRepository
│   └── RideRepository
│
├── dto
│   ├── RiderRequestDTO
│   ├── DriverRequestDTO
│   ├── RideRequestDTO
│   └── RideResponseDTO
│
├── entity
│   ├── Rider
│   ├── Driver
│   ├── Ride
│   └── RideStatus
│
└── exception
    ├── ResourceNotFoundException
    └── GlobalExceptionHandler
```

---

## Database Tables

### Rider

- id
- name
- phone
- email
- address
- gender
- registeredAt

### Driver

- id
- name
- phone
- vehicleNumber
- vehicleType
- available
- rating
- totalTrips
- registeredAt

### Ride

- id
- pickupLocation
- dropLocation
- status
- fare
- distanceKm
- paymentMode
- rideDate
- rider_id
- driver_id

---

## Ride Lifecycle

REQUESTED

↓

ACCEPTED

↓

STARTED

↓

COMPLETED

---

## API Endpoints

### Rider APIs

#### Register Rider

```http
POST /api/riders
```

#### Get Rider By ID

```http
GET /api/riders/{id}
```

#### Get All Riders

```http
GET /api/riders
```

---

### Driver APIs

#### Register Driver

```http
POST /api/drivers
```

#### Get Driver By ID

```http
GET /api/drivers/{id}
```

#### Get All Drivers

```http
GET /api/drivers
```

---

### Ride APIs

#### Request Ride

```http
POST /api/rides/request
```

#### Update Ride Status

```http
PUT /api/rides/{rideId}/status?status=ACCEPTED
```

Status Values:

- REQUESTED
- ACCEPTED
- STARTED
- COMPLETED

#### Ride History

```http
GET /api/rides/history/{riderId}
```

---

## Business Logic

1. Rider registers in the system.
2. Driver registers and becomes available.
3. Rider requests a ride.
4. System automatically assigns an available driver.
5. Ride status changes from REQUESTED → ACCEPTED → STARTED → COMPLETED.
6. After ride completion, the driver becomes available again.
7. Ride history is stored and can be viewed later.

---

## Exception Handling

Global Exception Handling is implemented using:

```java
@RestControllerAdvice
```

Example Error Response:

```json
{
  "message": "Driver not found",
  "status": 404
}
```

---

## Future Enhancements

- Driver Rating System
- Dynamic Fare Calculation
- GPS Tracking
- Online Payment Integration
- Ride Cancellation
- JWT Authentication

---
