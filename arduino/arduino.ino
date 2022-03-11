int fanAPin = 3;
int fanBPin = 5;
int fanCPin = 6;
int fanDPin = 9;
int fanEPin = 10;
int fanFPin = 11;
int fanExhaustPin = 8;
bool fanAOn = false;
bool fanBOn = false;
bool fanCOn = false;
bool fanDOn = false;
bool fanEOn = false;
bool fanFOn = false;
bool fanExhaustOn = false;

void setup() {
  pinMode(fanAPin, OUTPUT);
  pinMode(fanBPin, OUTPUT);
  pinMode(fanCPin, OUTPUT);
  pinMode(fanDPin, OUTPUT);
  pinMode(fanEPin, OUTPUT);
  pinMode(fanFPin, OUTPUT);
  pinMode(fanExhaustPin, OUTPUT);

  Serial.begin(9600);
}

int selectedFan = 0;

void loop() {
  while (Serial.available() > 0) {
    unsigned char incomingByte = Serial.read();

    if (incomingByte == 'A') {
      selectedFan = 1;
    } else if (incomingByte == 'B') {
      selectedFan = 2;
    } else if (incomingByte == 'C') {
      selectedFan = 3;
    } else if (incomingByte == 'D') {
      selectedFan = 4;
    } else if (incomingByte == 'E') {
      selectedFan = 5;
    } else if (incomingByte == 'F') {
      selectedFan = 6;
    } else if (incomingByte == 'G') {
      selectedFan = 7;
    } else if (incomingByte == '0' && selectedFan == 1) {
      fanAOn = false;
    } else if (incomingByte == '0' && selectedFan == 2) {
      fanBOn = false;
    } else if (incomingByte == '0' && selectedFan == 3) {
      fanCOn = false;
    } else if (incomingByte == '0' && selectedFan == 4) {
      fanDOn = false;
    } else if (incomingByte == '0' && selectedFan == 5) {
      fanEOn = false;
    } else if (incomingByte == '0' && selectedFan == 6) {
      fanFOn = false;
    } else if (incomingByte == '0' && selectedFan == 7) {
      fanExhaustOn = false;
    } else if (incomingByte == '1' && selectedFan == 1) {
      fanAOn = true;
    } else if (incomingByte == '1' && selectedFan == 2) {
      fanBOn = true;
    } else if (incomingByte == '1' && selectedFan == 3) {
      fanCOn = true;
    } else if (incomingByte == '1' && selectedFan == 4) {
      fanDOn = true;
    } else if (incomingByte == '1' && selectedFan == 5) {
      fanEOn = true;
    } else if (incomingByte == '1' && selectedFan == 6) {
      fanFOn = true;
    } else if (incomingByte == '1' && selectedFan == 7) {
      fanExhaustOn = true;
    }
  }
  
  analogWrite(fanAPin, fanAOn ? 255 : 0);
  analogWrite(fanBPin, fanBOn ? 200 : 0);
  analogWrite(fanCPin, fanCOn ? 200 : 0);
  analogWrite(fanDPin, fanDOn ? 200 : 0);
  analogWrite(fanEPin, fanEOn ? 200 : 0);
  analogWrite(fanFPin, fanFOn ? 170 : 0);
  digitalWrite(fanExhaustPin, fanExhaustOn ? HIGH : LOW);
}
