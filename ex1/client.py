import socket, select, sys

list_of_socket = []

s = socket.socket()

s.connect(('127.0.0.1', 12345))

while True:
    list_of_socket = [sys.stdin, s]

    read_sockets, write_sockets, error_sockets = select.select(list_of_socket , [], [])

    for socket in read_sockets:

        if socket == s:

            data = socket.recv(1024)

            print data

        else:
            msg = sys.stdin.readline()

            s.send(msg)
