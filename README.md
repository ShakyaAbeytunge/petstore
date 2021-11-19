# PetStore Application

API application for a pet store using microprofile.io.
This is a Java application developed upon Open Liberty with Maven and Docker.

## What is petstore API?

You can View/Add/Update/Delete pets in the store and pet types.
A pet has an id, name, type and age.

## How to run the API?

### Prerequisites

- OpenJDK JDK-11
- Maven Installed (version 3.8.1)
- Docker Installed

1. Clone the repository to a prefered location on your local machine.

`git clone https://github.com/ShakyaAbeytunge/petstore`\
`cd petstore`

2. Build and run your Open Liberty project.

`mvn liberty:run`

When the server begins starting up, various messages display in your command-line session. Wait for the following message, which indicates that the server startup is complete:

`[INFO] [AUDIT] CWWKF0011I: The server defaultServer is ready to run a smarter planet.`

3. Try API commands.

Try out following API calls with you browser or POSTMAN client while the server running in the background.

- View details of all pets in the store

_GET_
`http://localhost:9080/petstore/pets`

- View pet details by petID

_GET_
`http://localhost:9080/petstore/pets/{petId}`

- View pet details by petName

_GET_
`http://localhost:9080/petstore/pets/name/{petName}`

- View pet details by petType

_GET_
`http://localhost:9080/petstore/pets/type/{petType}`

- Delete details of a pet by ID

_DELETE_
`http://localhost:9080/petstore/pets/{petId}`

- Insert details of a new pet

_POST_
`http://localhost:9080/petstore/pets`

- Update detaills of an existing pet

_PUT_
`http://localhost:9080/petstore/pets`

- View pet types at store

_GET_
`http://localhost:9080/petstore/pets/types`

- Delete pet type along with the pets belongs to that type

_DELETE_
`http://localhost:9080/petstore/pets/deleteType/{petType}`

4. Stop the server

`mvn liberty:stop`
