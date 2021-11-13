package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;



public class RonMK1 extends SubsystemBase{  
    private static RonMK1 m_instance;
    //TalonSRX _talon = new TalonSRX(20);
   // TalonSRX _talon2 = new TalonSRX(21);

    CANSparkMax _Shooter1 = new CANSparkMax(20, MotorType.kBrushless);
    CANSparkMax _Shooter2 = new CANSparkMax(21, MotorType.kBrushless);



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
        _Shooter1.set(percent);
        _Shooter2.set(-percent);
      
    }
    public void setBrakeMode(boolean mode){
        if (mode == true){
            _Shooter1.setIdleMode(IdleMode.kBrake);
            _Shooter2.setIdleMode(IdleMode.kBrake);
            //_talon2.setNeutralMode(NeutralMode.Brake);
           
        }
        else{
            _Shooter1.setIdleMode(IdleMode.kCoast);
            _Shooter2.setIdleMode(IdleMode.kCoast);
        ;

        }
    }


}
