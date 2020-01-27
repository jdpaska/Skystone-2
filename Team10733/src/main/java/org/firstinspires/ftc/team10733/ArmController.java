package org.firstinspires.ftc.team10733;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import static java.lang.Thread.sleep;

public class ArmController {

    //define the arm devices
    private Servo leftServo;
    private Servo  rightServo;
    private DcMotor armMotor = null;
    private Servo leftTray;
    private Servo rightTray;
    //private HardwareMap hardwareMap = null;

    //set min and max servo positions
    double LEFT_MAX_POS     =  1.0;     // Maximum rotational position
    double LEFT_MIN_POS     =  0.0;     // Minimum rotational position
    double RIGHT_MAX_POS     =  1.0;     // Maximum rotational position
    double RIGHT_MIN_POS     =  0.0;     // Minimum rotational position
    double LEFT_OPEN_POS     =  0.8;     // Maximum rotational position
    double LEFT_CLOSED_POS     =  0.67;     // Minimum rotational position
    double RIGHT_OPEN_POS     =  0.2;     // Maximum rotational position
    double RIGHT_CLOSED_POS     =  0.33;     // Minimum rotational position
    double LEFT_HOME_POS     =  0.02 ;
    double RIGHT_HOME_POS     =  0.91;
    double LEFT_DOWN_POS     =  0.5; //good
    double RIGHT_UP_POS     =  0.8;//
    double RIGHT_DOWN_POS     =  0.0;//good
    double LEFT_UP_POS     =  0.9;// good


    public double getArmPower() {
        return armPower;
    }

    double armPower;


    double  leftServoPosition = .5; // left servo start position
    double  rightServoPosition = .5; // right servo start position
    double INCREMENT   = 0.01;

    double  armPowerBias = .8;//slow the arm motor
    //COUGARS: need to have a way to limit how far the arm will extend or contract.

    public ArmController (HardwareMap hardwareMap){

        leftServo = hardwareMap.get(Servo.class, "left_hand");
        rightServo = hardwareMap.get(Servo.class, "right_hand");
        armMotor = hardwareMap.get(DcMotor.class, "arm_motor");
        leftTray = hardwareMap.get(Servo.class, "left_tray");
        rightTray = hardwareMap.get(Servo.class, "right_tray");


    }

  public void extend(double power) {
    //extend the arm



      armPower = power * armPowerBias;

      //set motor direction
      ///armMotor.setDirection(DcMotorSimple.Direction.REVERSE);

      //reset the motors encoder
      /*
      armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      armMotor.setTargetPosition(1000); //set the position

      armMotor.setDirection(DcMotor.Direction.REVERSE);
      //set motor to run to a position and stop
      armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

      //motor will only move with power
      */

      armMotor.setPower(armPower);

//set motor power to zero
      armMotor.setPower(0);

}

    public void retract(){
    //retract the arm to home position
//COUGARS: basically do the reverse of extend.  Run to a position that fully retracts the arm.


    }


    public void freeGrab(double servoDirection){
        //freely grab and release
        if (servoDirection > 0) {

            if ((leftServoPosition < LEFT_MAX_POS) && (rightServoPosition > RIGHT_MIN_POS)) {
                leftServoPosition += INCREMENT;
                rightServoPosition -= INCREMENT;
            }
        }
        else if (servoDirection < 0){
            if ((leftServoPosition > LEFT_MIN_POS ) && (rightServoPosition < RIGHT_MAX_POS)) {
                leftServoPosition -= INCREMENT ;
                rightServoPosition += INCREMENT ;
            }
        }

        /*telemetry.addData("Left Servo Position", "%5.2f", leftServoPosition);
        telemetry.addData("Right Servo Position", "%5.2f", rightServoPosition);
        telemetry.addData( "Arm Motor Power:" ,"%5.2f",armPower);
        telemetry.addData(">", "Press Stop to end test." );
        telemetry.update();*/

        // Set the servo to the new position and pause;
        leftServo.setPosition(leftServoPosition);
        rightServo.setPosition(rightServoPosition);
        //sleep(CYCLE_MS);
        //idle();

    }


    public void grab(){
    //grab the block by moving the two servos inward

        leftServoPosition = LEFT_CLOSED_POS;
        leftServo.setPosition(leftServoPosition);
        rightServoPosition = RIGHT_CLOSED_POS;
        rightServo.setPosition(rightServoPosition);

        //while ((leftServoPosition < LEFT_MAX_POS) && (rightServoPosition > RIGHT_MIN_POS)) {
         //   leftServoPosition = LEFT_CLOSED_POS;
         //   leftServo.setPosition(leftServoPosition);
           // rightServoPosition = RIGHT_CLOSED_POS;
           // rightServo.setPosition(rightServoPosition);
       // }



    }
    public void release() {
        //release the block by moving the two servos outward
        leftServoPosition = LEFT_OPEN_POS;
        leftServo.setPosition(leftServoPosition);
        rightServoPosition = RIGHT_OPEN_POS;
        rightServo.setPosition(rightServoPosition);
        /*
        while ((leftServoPosition > LEFT_MIN_POS) && (rightServoPosition < RIGHT_MAX_POS)) {
            leftServoPosition = LEFT_OPEN_POS;
            leftServo.setPosition(leftServoPosition);
            rightServoPosition = RIGHT_OPEN_POS;
            rightServo.setPosition(rightServoPosition);

        }
         */
    }

        public void servosToHome(){

            rightServoPosition = RIGHT_HOME_POS;
            rightServo.setPosition(rightServoPosition);
            //need to wait for right server to finish so the two grabbers don't hit each other
            // add that code here

            leftServoPosition = LEFT_HOME_POS;
            leftServo.setPosition(leftServoPosition);



        }


    public void trayGrab(){

        leftTray.setPosition(LEFT_DOWN_POS);
        rightTray.setPosition(RIGHT_DOWN_POS);

    }


    public void trayRelease(){

        leftTray.setPosition(LEFT_UP_POS);
        rightTray.setPosition(RIGHT_UP_POS);

    }






    }








