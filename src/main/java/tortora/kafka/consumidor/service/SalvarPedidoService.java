package tortora.kafka.consumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tortora.kafka.consumidor.data.PedidoData;

@Slf4j
@Service
public class SalvarPedidoService {

    @KafkaListener(topics = "SalvarPedido", groupId = "MicrosservicoSalvaPedido")
    private void executar(ConsumerRecord<String, String> record) {

        log.info("Key = {} ", record.key());
        log.info("Header = {} ", record.headers());
        log.info("Partition = {} ", record.partition());

        String dados = record.value();

        ObjectMapper mapper = new ObjectMapper();

        PedidoData pedido;

        try {
            pedido = mapper.readValue(dados, PedidoData.class);
        } catch (JsonProcessingException e) {
            log.error("Falha ao converter evento [dado={}]", dados, e);
            return;
        }

        log.info("Evento recebido {}", pedido);

        gravar(pedido);
        // Responder para a fila de que o pedido foi salvo

    }

    private void gravar(PedidoData pedido) {
        // Gravar pedido no banco de dados
    }

}
