package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;
public class Climber {
    private static Climber m_instance;
    TalonSRX _talon3 = new TalonSRX(23);

    public Climber(){
        super();
        setBrakeMode(true);
    }





    public static Climber getInstance(){
        if(m_instance == null){
            m_instance = new Climber();

        }
        return m_instance;
    }

    public void RunClimber(double percent){
        _talon3.set(ControlMode.PercentOutput, percent);

    }
    public void setBrakeMode(boolean mode){
        if (mode == true){
            _talon3.setNeutralMode(NeutralMode.Brake);
        }
        else{
            _talon3.setNeutralMode(NeutralMode.Coast);
        }
    }
}
