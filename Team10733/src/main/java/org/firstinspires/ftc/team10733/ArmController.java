package org.firstinspires.ftc.team10733;

import com.qualcomm.robotcore.hardware.DcMotor;
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

    double  leftServoPosition = .5; // left servo start position
    double  rightServoPosition = .5; // right servo start position

public void extend() {
    //extend the arm


}

    public void retract(){
    //retract the arm


    }
    public void grab(){
    //grab the block


    }
    public void release(){
    //release the block


    }







}
