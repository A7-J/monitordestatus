# 📱 Monitor de Status do Dispositivo

Aplicativo Android nativo desenvolvido em **Java** para demonstrar o uso de **Broadcast Receivers**, **LocalBroadcastManager** e **Notificações**.

## 🎯 Objetivo

Demonstrar, de forma prática e didática:

* BroadcastReceiver **estático** (bateria baixa)
* BroadcastReceiver **dinâmico** (conectividade)
* Comunicação interna com **LocalBroadcastManager**
* Atualização da **interface (UI)** em tempo real

## 🛠️ Tecnologias

* Java
* Android SDK (API 21+)
* AppCompat
* ConstraintLayout
* LocalBroadcastManager
* NotificationCompat

## 📦 Estrutura de Pacotes

```text
com.example.monitordestatus
├── ui        → MainActivity
├── receiver  → BroadcastReceivers
├── util      → Constantes
```

## 🔔 Funcionalidades

* Alerta por **notificação** quando a bateria está fraca
* Monitoramento da **conectividade** da internet
* Exibição de eventos em um **log na tela**

## ⚠️ Observações

* Algumas APIs utilizadas são **deprecated**, mantidas intencionalmente para fins acadêmicos
* Warnings de compilação não afetam a execução do app

## ▶️ Execução

1. Abrir no Android Studio
2. Sincronizar o Gradle
3. Executar em emulador ou dispositivo físico

---

📚 Projeto desenvolvido para **fins educacionais**.
