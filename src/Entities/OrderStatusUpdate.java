package Entities;

public class OrderStatusUpdate {
    private long orderId;

    public OrderStatusUpdate(long orderId) {
        this.orderId = orderId;
    }

    public void updateStatus(String newStatus) {
        Thread thread = new Thread(() -> {
            try {
                System.out.printf("Pedido %d atualizado para o status: %s%n", orderId, newStatus);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public void startUpdateProcess() {
        new Thread(() -> {
            try {
                updateStatus("Produção");
                Thread.sleep(5000);
                updateStatus("Saiu para entrega");
                Thread.sleep(5000);
                updateStatus("Entregue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

