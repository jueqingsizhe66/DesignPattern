import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithStatusModeTest extends JFrame {
	private JButton btnPay;
	private JButton btnRefund;
	private JButton btnConfirm;
	private JLabel labelState;
	private IOrderState state;
	
	public WithStatusModeTest() {
		super("测试");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		
		btnPay = new JButton("付款");
		btnPay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WithStatusModeTest.this.state.pay();
			}
		});
		
		btnRefund = new JButton("退款");
		btnRefund.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WithStatusModeTest.this.state.refund();
			}
		});
		
		btnConfirm = new JButton("确认收货");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WithStatusModeTest.this.state.confirm();
			}
		});
		
		labelState = new JLabel();
		GridLayout gird = new GridLayout(3, 3);
		contentPane.setLayout(gird);
		
		contentPane.add(btnPay);
		contentPane.add(btnRefund);
		contentPane.add(btnConfirm);
		contentPane.add(labelState);
		setState(new UnPayedState());
	}
	
	public void setState(IOrderState stat) {
		this.state = stat;
		this.state.updateUI();
	}
	
	public static void main(String[] args) {
		WithStatusModeTest t = new WithStatusModeTest();
		t.pack();
	}
	
	interface IOrderState {
		void updateUI();
		
		void pay();
		
		void refund();
		
		void confirm();
	}
	
	class UnPayedState implements IOrderState {
		
		@Override
		public void updateUI() {
			WithStatusModeTest.this.btnConfirm.setEnabled(false);
			WithStatusModeTest.this.btnPay.setEnabled(true);
			WithStatusModeTest.this.btnRefund.setEnabled(false);
			WithStatusModeTest.this.labelState.setText("Without Payed");
		}
		
		@Override
		public void pay() {
			WithStatusModeTest.this.setState(new PayedState());
		}
		
		@Override
		public void refund() {
			throw new RuntimeException("Cannot refund without pay!!!!!!!!!!!!");
		}
		
		@Override
		public void confirm() {
			throw new RuntimeException("Cannot confirm without pay!!!!!!!!!");
		}
	}
	
	class PayedState implements IOrderState {
		
		@Override
		public void updateUI() {
			WithStatusModeTest.this.btnConfirm.setEnabled(true);
			WithStatusModeTest.this.btnPay.setEnabled(false);
			WithStatusModeTest.this.btnRefund.setEnabled(true);
			WithStatusModeTest.this.labelState.setText("Have been payed");
		}
		
		@Override
		public void pay() {
			throw new RuntimeException("已经支付，不需要重复支付");
		}
		
		@Override
		public void refund() {
			WithStatusModeTest.this.setState(new UnPayedState());
		}
		
		@Override
		public void confirm() {
			WithStatusModeTest.this.setState(new ConfirmedState());
		}
		
	}
	
	class RefundedState implements IOrderState {
		
		@Override
		public void updateUI() {
			WithStatusModeTest.this.btnConfirm.setEnabled(false);
			WithStatusModeTest.this.btnPay.setEnabled(false);
			WithStatusModeTest.this.btnRefund.setEnabled(false);
			WithStatusModeTest.this.labelState.setText("已退款");
			
		}
		
		@Override
		public void pay() {
			throw new RuntimeException("已经退款，无法支付");
		}
		
		@Override
		public void refund() {
			throw new RuntimeException("已经退款，不能重复退款");
		}
		
		@Override
		public void confirm() {
			throw new RuntimeException("已经退款，不能确认");
		}
		
	}
	
	class ConfirmedState implements IOrderState {
		@Override
		public void updateUI() {
			WithStatusModeTest.this.btnConfirm.setEnabled(false);
			WithStatusModeTest.this.btnPay.setEnabled(false);
			WithStatusModeTest.this.btnRefund.setEnabled(false);
			WithStatusModeTest.this.labelState.setText("确认收货");
			
		}
		
		@Override
		public void pay() {
			throw new RuntimeException("已经确认，不能重复支付");
		}
		
		@Override
		public void refund() {
			throw new RuntimeException("已经确认，不能退款");
			
		}
		
		@Override
		public void confirm() {
			throw new RuntimeException("已经确认，不能重复确认");
			
		}
		
	}
	
}

