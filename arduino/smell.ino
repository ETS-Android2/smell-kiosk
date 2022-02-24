int fanAPin = 3;
int fanBPin = 5;
int fanCPin = 6;
int fanDPin = 9;
int fanEPin = 10;
int fanFPin = 11;
bool fanAOn = false;
bool fanBOn = false;
bool fanCOn = false;
bool fanDOn = false;
bool fanEOn = false;
bool fanFOn = false;
int fanSpeed = 150;

void setup() {
  pinMode(fanAPin, OUTPUT);
  pinMode(fanBPin, OUTPUT);
  pinMode(fanCPin, OUTPUT);
  pinMode(fanDPin, OUTPUT);
  pinMode(fanEPin, OUTPUT);
  pinMode(fanFPin, OUTPUT);

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
    }
  }
  
  analogWrite(fanAPin, fanAOn ? fanSpeed : 0);
  analogWrite(fanBPin, fanBOn ? fanSpeed : 0);
  analogWrite(fanCPin, fanCOn ? fanSpeed : 0);
  analogWrite(fanDPin, fanDOn ? fanSpeed : 0);
  analogWrite(fanEPin, fanEOn ? fanSpeed : 0);
  analogWrite(fanFPin, fanFOn ? fanSpeed : 0);
}
