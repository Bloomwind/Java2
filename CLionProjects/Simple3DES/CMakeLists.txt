cmake_minimum_required(VERSION 3.25)
project(Simple3DES)

set(CMAKE_CXX_STANDARD 17)

add_executable(Simple3DES main.cpp)

find_package(OpenSSL REQUIRED)

include_directories(${OPENSSL_INCLUDE_DIR})

target_link_libraries(Simple3DES ${OPENSSL_LIBRARIES})
