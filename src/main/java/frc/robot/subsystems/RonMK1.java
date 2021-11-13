package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



public class RonMK1 extends SubsystemBase{  
    private static RonMK1 m_instance;
    TalonSRX _talon = new TalonSRX(20);
    TalonSRX _talon2 = new TalonSRX(21);



    public RonMK1(){
        super();
        setBrakeMode(true);
       

    }




    public static RonMK1 getInstance(){
        if (m_instance == null){
            m_instance = new RonMK1();
        }
        return m_instance;
    }




    public void FireRon(double percent){
        _talon.set(ControlMode.PercentOutput, percent);
        _talon2.set(ControlMode.PercentOutput,-percent);
      
    }
    public void setBrakeMode(boolean mode){
        if (mode == true){
            _talon.setNeutralMode(NeutralMode.Brake);
            _talon2.setNeutralMode(NeutralMode.Brake);
           
        }
        else{
            _talon.setNeutralMode(NeutralMode.Coast);
            _talon2.setNeutralMode(NeutralMode.Coast);
        ;

        }
    }


}
