package org.firstinspires.ftc.team10733;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmController {

    //define the arm devices
    private Servo leftServo;
    private Servo  rightServo;
    private DcMotor armMotor = null;

    //set min and max servo positions
    static final double LEFT_MAX_POS     =  1.0;     // Maximum rotational position
    static final double LEFT_MIN_POS     =  0.0;     // Minimum rotational position
    static final double RIGHT_MAX_POS     =  1.0;     // Maximum rotational position
    static final double RIGHT_MIN_POS     =  0.0;     // Minimum rotational position

    leftServo = hardwareMap.get(Servo.class, "left_hand");
    rightServo = hardwareMap.get(Servo.class, "right_hand");
    armMotor = hardwareMap.get(DcMotor.class, "arm_motor");

    double  leftServoPosition = .5; // left servo start position
    double  rightServoPosition = .5; // right servo start position
    static final double INCREMENT   = 0.01;

    double  armPowerBias = .2;//slow the arm motor
    //COUGARS: need to have a way to limit how far the arm will extend or contract.

  public void extend(double power) {
    //extend the arm

      double armPower;
      armPower = power * armPowerBias;

      //set motor direction
      ///armMotor.setDirection(DcMotorSimple.Direction.REVERSE);

      //reset the motors encoder
      armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

      //set motor to run to a position and stop
      armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      //set the position
      armMotor.setTargetPosition(400);//
      //motor will only move with power
      armMotor.setPower(armPower);




//set motor power to zero
      armMotor.setPower(0);

}

    public void retract(){
    //retract the arm
//COUGARS: basically do the reverse of extend.  Run to a position that fully retracts the arm.

    }
    public void grab(){
    //grab the block by moving the two servos inward
        while ((leftServoPosition < LEFT_MAX_POS) && (rightServoPosition > RIGHT_MIN_POS)) {
            leftServoPosition += INCREMENT;
            rightServoPosition -= INCREMENT;
        }



    }
    public void release(){
    //release the block by moving the two servos outward
        while ((leftServoPosition > LEFT_MIN_POS) && (rightServoPosition < RIGHT_MAX_POS)) {
            leftServoPosition -= INCREMENT;
            rightServoPosition += INCREMENT;
        }





    }







}
