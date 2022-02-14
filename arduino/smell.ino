int fanAPin = 3;
int fanBPin = 5;
bool fanAOn = false;
bool fanBOn = false;
int fanSpeed = 150;

void setup() {
  pinMode(fanAPin, OUTPUT);
  pinMode(fanBPin, OUTPUT);

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
    } else if (incomingByte == '0' && selectedFan == 1) {
      fanAOn = false;
    } else if (incomingByte == '0' && selectedFan == 2) {
      fanBOn = false;
    } else if (incomingByte == '1' && selectedFan == 1) {
      fanAOn = true;
    } else if (incomingByte == '1' && selectedFan == 2) {
      fanBOn = true;
    }
  }
  
  analogWrite(fanAPin, fanAOn ? fanSpeed : 0);
  analogWrite(fanBPin, fanBOn ? fanSpeed : 0);
}
