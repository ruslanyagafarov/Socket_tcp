# Socket / TCP Protocol
В первую очередь импортируем библиотеку для работы с Сокетами.
```java
import java.net.ServerSocket;
```
Обрабатываем в методе класса ошибки Input / Output.
```java
public static void main(String[] args) throws IOException {
```
Создаем объект класса ServerSocket и пропишем в нем порт к которому может подключиться наш клиент <br>
Далее добавим переменные - контейнеры для InputStream и OutputStream.
```java
try (var serverSocket = new ServerSocket(8080);
     //метод accept будет ждать клиента и когда он подключиться кроме него никто этого сделать не сможет
     var socket = serverSocket.accept();
     var inputStream = new DataInputStream(socket.getInputStream());
     var outputStream = new DataOutputStream(socket.getOutputStream())) {
```
После добавления этих переменных с которыми впоследствии будем работать, создали переменную для чтения информации с консоли, переменную для получения запросов и сделали цикл, который будет получать запросы от клиента пока он не напишет слово exit после чего сервер остановиться и не будет принимать запросы.
```java
var scanner = new Scanner(System.in);
var request = inputStream.readUTF();
while (!request.equals("exit")) {
  System.out.println("Клиент: " + request);
  outputStream.writeUTF(scanner.nextLine());
  request = inputStream.readUTF();
}
```
## Принцип работы TCP протокола
*Открывается соединение* > *Отправляется запрос* > *Получаем ответ* > *Закрывается соединение*
