package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "mjControlSchemeDesign (Blocks to Java)")
public class mjControlSchemeDesign extends LinearOpMode {

  private DcMotor motor0;
  private DcMotor motor1;
  private DcMotor motor2;
  
  public void controller(){
      double d0x = -0.5;
      double d0y = 0.866;
      double d1x = 0.5;
      double d1y = 0.866;
      double d2x = 1;
      double d2y = 0;
      float gpx = gamepad1.left_stick_x;
      float gpy = gamepad1.left_stick_y;
      motor0.setPower(d0x * gpx + d0y * gpy);
      motor1.setPower(d1x * gpx + d1y * gpy);
      motor2.setPower(d2x * gpx + d2y * gpy);
      }
  
  
  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    motor0 = hardwareMap.get(DcMotor.class, "motor0");
    motor1 = hardwareMap.get(DcMotor.class, "motor1");
    motor2 = hardwareMap.get(DcMotor.class, "motor2");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      motor2.setDirection(DcMotorSimple.Direction.REVERSE);
      motor1.setDirection(DcMotorSimple.Direction.REVERSE);
      
      
      // Put run blocks here.
      while (opModeIsActive()) {
        controller();
        
        
        telemetry.update();
      }
    }
    
  }
}
