#!/bin/bash
#Functionalitate de pk adaugata in cazul in care avem doua persoane cu acelasi nume in baza de date sa nu le stergem pe amandoua

if [ ! -e "db.csv" ]; then
    echo "Client PK,Client Name,Client Sold" > db.csv
    echo 0 > pk.txt
fi

function get_next_pk() {
    pk=$(<pk.txt)
    next_pk=$((pk + 1))
    echo "$next_pk" > pk.txt
    echo "$pk"
}

function create_client() {

    pk=$(get_next_pk)
    echo "Create client"
    read -p "Client name :" client_name
    client_sold=0
    echo "$pk,$client_name,$client_sold" >> db.csv
    echo "Client with PK $pk created successfully"
}

function modify_sold() {
    echo "Modify sold"
    read -p "Enter client PK: " client_pk
    read -p "Enter new sold value: " new_sold
    if [ grep "^$client_pk,"  db.csv ]; then
        sed -i "s/^$client_pk,[^,]*/$client_pk,$new_sold/" db.csv
        if [ $? -eq 0 ]; then
            echo "Sold for client with PK '$client_pk' modified to $new_sold"
        fi
    else
        echo "Client with PK '$client_pk' not found"
    fi
}

function delete_client() {
    echo "Delete client"
    read -p "Enter client PK: " client_pk
    if grep [ "^$client_pk," db.csv ]; then
        sed -i "/^$client_pk,/d" db.csv
        if [ $? -eq 0 ]; then
            echo "Client with PK '$client_pk' deleted from database"
        fi
    else
        echo "Client with PK '$client_pk' not found"
    fi
}

function display_clients() {
    echo "Current clients"
    cat db.csv
}


while true; do
    echo "Bank Management System"
    echo "1. Create new client"
    echo "2. Modify client sold"
    echo "3. Delete client"
    echo "4. Display clients list"
    echo "5. Exit"
    read -p "Select an option: " choice
    case $choice in
        1) create_client ;;
        2) modify_sold ;;
        3) delete_client ;;
        4) display_clients ;;
        5) echo "Exiting program"; exit ;;
        *) echo "Invalid option";;
    esac
done
