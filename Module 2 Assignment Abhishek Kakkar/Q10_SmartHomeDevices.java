import java.util.Scanner;

interface Device {
    void turnOn();
    void turnOff();
}

class Fan implements Device {
    public void turnOn() {
        System.out.println("Fan is now ON");
    }

    public void turnOff() {
        System.out.println("Fan is now OFF");
    }
}

class Light implements Device {
    public void turnOn() {
        System.out.println("Light is now ON");
    }

    public void turnOff() {
        System.out.println("Light is now OFF");
    }
}

public class Q10_SmartHomeDevices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) continue;

            Device device;
            if (input.equalsIgnoreCase("Fan")) {
                device = new Fan();
            } else if (input.equalsIgnoreCase("Light")) {
                device = new Light();
            } else {
                System.out.println("Unknown device");
                continue;
            }

            device.turnOn();
            device.turnOff();
        }

        sc.close();
    }
}
