# File IO Classes, Functions

```java

/* INPUT */

Path filePath = Paths.get("A.txt");
// 파라미터로 파일 정보를 전달하여 경로를 변수에 할당.

byte[] bytes = Files.readAllBytes(filePath);
// 파라미터로 받은 경로의 파일에 액세스하여 모든 데이터를 Byte 타입으로 읽고 이를 return.

String str = new String(bytes);
// 바이트코드 파일 객체를 String 객체로 만들어 str에 할당.

String[] strArr = str.split("구분문자");
// 하나의 문자열로 만든 바이너리 파일을, 구분 문자로 스플릿하여 String Array로 만듦.



/* OUTPUT */

int bufferSize = 10240;
// 버퍼의 사이즈를 정한다.

ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
// 파라미터로 받은 버퍼 사이즈대로 버퍼를 만들고, 이를 참조변수 buffer에 할당.

buffer.put

```