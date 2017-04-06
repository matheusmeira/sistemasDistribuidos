import socket, select, sys

list_of_socket = []

s = socket.socket()
host = socket.gethostname()
port = 12345
s.bind(('127.0.0.1', port))

s.listen(5)
list_of_socket.append(s)

while True:
    read_sockets,write_sockets,error_sockets = select.select(list_of_socket,[],[])

    for socket in read_sockets:

        if socket == s:

            c, addr = s.accept()

            list_of_socket.append(c)

            print 'Enviando mensagem'

            mensagem = sys.stdin.readline()

            c.send(mensagem)
        else:
            data = socket.recv(1024)
            print data
