package org.example;

import java.util.HashMap;
import java.util.Map;

public class EVMAssembler {
    private static final Map<String, String> OPCODES = new HashMap<>();

    static {
        OPCODES.put("STOP", "00");
        OPCODES.put("ADD", "01");
        OPCODES.put("MUL", "02");
        OPCODES.put("SUB", "03");
        OPCODES.put("DIV", "04");
        OPCODES.put("SDIV", "05");
        OPCODES.put("MOD", "06");
        OPCODES.put("SMOD", "07");
        OPCODES.put("ADDMOD", "08");
        OPCODES.put("MULMOD", "09");
        OPCODES.put("EXP", "0a");
        OPCODES.put("SIGNEXTEND", "0b");
        OPCODES.put("LT", "10");
        OPCODES.put("GT", "11");
        OPCODES.put("SLT", "12");
        OPCODES.put("SGT", "13");
        OPCODES.put("EQ", "14");
        OPCODES.put("ISZERO", "15");
        OPCODES.put("AND", "16");
        OPCODES.put("OR", "17");
        OPCODES.put("XOR", "18");
        OPCODES.put("NOT", "19");
        OPCODES.put("BYTE", "1a");
        OPCODES.put("SHL", "1b");
        OPCODES.put("SHR", "1c");
        OPCODES.put("SAR", "1d");
        OPCODES.put("SHA3", "20");
        OPCODES.put("ADDRESS", "30");
        OPCODES.put("BALANCE", "31");
        OPCODES.put("ORIGIN", "32");
        OPCODES.put("CALLER", "33");
        OPCODES.put("CALLVALUE", "34");
        OPCODES.put("CALLDATALOAD", "35");
        OPCODES.put("CALLDATASIZE", "36");
        OPCODES.put("CALLDATACOPY", "37");
        OPCODES.put("CODESIZE", "38");
        OPCODES.put("CODECOPY", "39");
        OPCODES.put("GASPRICE", "3a");
        OPCODES.put("EXTCODESIZE", "3b");
        OPCODES.put("EXTCODECOPY", "3c");
        OPCODES.put("RETURNDATASIZE", "3d");
        OPCODES.put("RETURNDATACOPY", "3e");
        OPCODES.put("EXTCODEHASH", "3f");
        OPCODES.put("BLOCKHASH", "40");
        OPCODES.put("COINBASE", "41");
        OPCODES.put("TIMESTAMP", "42");
        OPCODES.put("NUMBER", "43");
        OPCODES.put("DIFFICULTY", "44");
        OPCODES.put("GASLIMIT", "45");
        OPCODES.put("CHAINID", "46");
        OPCODES.put("SELFBALANCE", "47");
        OPCODES.put("BASEFEE", "48");
        OPCODES.put("POP", "50");
        OPCODES.put("MLOAD", "51");
        OPCODES.put("MSTORE", "52");
        OPCODES.put("MSTORE8", "53");
        OPCODES.put("SLOAD", "54");
        OPCODES.put("SSTORE", "55");
        OPCODES.put("JUMP", "56");
        OPCODES.put("JUMPI", "57");
        OPCODES.put("PC", "58");
        OPCODES.put("MSIZE", "59");
        OPCODES.put("GAS", "5a");
        OPCODES.put("JUMPDEST", "5b");
        OPCODES.put("PUSH1", "60");
        OPCODES.put("PUSH2", "61");
        OPCODES.put("PUSH3", "62");
        OPCODES.put("PUSH4", "63");
        OPCODES.put("PUSH5", "64");
        OPCODES.put("PUSH6", "65");
        OPCODES.put("PUSH7", "66");
        OPCODES.put("PUSH8", "67");
        OPCODES.put("PUSH9", "68");
        OPCODES.put("PUSH10", "69");
        OPCODES.put("PUSH11", "6a");
        OPCODES.put("PUSH12", "6b");
        OPCODES.put("PUSH13", "6c");
        OPCODES.put("PUSH14", "6d");
        OPCODES.put("PUSH15", "6e");
        OPCODES.put("PUSH16", "6f");
        OPCODES.put("PUSH17", "70");
        OPCODES.put("PUSH18", "71");
        OPCODES.put("PUSH19", "72");
        OPCODES.put("PUSH20", "73");
        OPCODES.put("PUSH21", "74");
        OPCODES.put("PUSH22", "75");
        OPCODES.put("PUSH23", "76");
        OPCODES.put("PUSH24", "77");
        OPCODES.put("PUSH25", "78");
        OPCODES.put("PUSH26", "79");
        OPCODES.put("PUSH27", "7a");
        OPCODES.put("PUSH28", "7b");
        OPCODES.put("PUSH29", "7c");
        OPCODES.put("PUSH30", "7d");
        OPCODES.put("PUSH31", "7e");
        OPCODES.put("PUSH32", "7f");
        OPCODES.put("DUP1", "80");
        OPCODES.put("DUP2", "81");
        OPCODES.put("DUP3", "82");
        OPCODES.put("DUP4", "83");
        OPCODES.put("DUP5", "84");
        OPCODES.put("DUP6", "85");
        OPCODES.put("DUP7", "86");
        OPCODES.put("DUP8", "87");
        OPCODES.put("DUP9", "88");
        OPCODES.put("DUP10", "89");
        OPCODES.put("DUP11", "8a");
        OPCODES.put("DUP12", "8b");
        OPCODES.put("DUP13", "8c");
        OPCODES.put("DUP14", "8d");
        OPCODES.put("DUP15", "8e");
        OPCODES.put("DUP16", "8f");
        OPCODES.put("SWAP1", "90");
        OPCODES.put("SWAP2", "91");
        OPCODES.put("SWAP3", "92");
        OPCODES.put("SWAP4", "93");
        OPCODES.put("SWAP5", "94");
        OPCODES.put("SWAP6", "95");
        OPCODES.put("SWAP7", "96");
        OPCODES.put("SWAP8", "97");
        OPCODES.put("SWAP9", "98");
        OPCODES.put("SWAP10", "99");
        OPCODES.put("SWAP11", "9a");
        OPCODES.put("SWAP12", "9b");
        OPCODES.put("SWAP13", "9c");
        OPCODES.put("SWAP14", "9d");
        OPCODES.put("SWAP15", "9e");
        OPCODES.put("SWAP16", "9f");
        OPCODES.put("LOG0", "a0");
        OPCODES.put("LOG1", "a1");
        OPCODES.put("LOG2", "a2");
        OPCODES.put("LOG3", "a3");
        OPCODES.put("LOG4", "a4");
        OPCODES.put("CREATE", "f0");
        OPCODES.put("CALL", "f1");
        OPCODES.put("CALLCODE", "f2");
        OPCODES.put("RETURN", "f3");
        OPCODES.put("DELEGATECALL", "f4");
        OPCODES.put("CREATE2", "f5");
        OPCODES.put("STATICCALL", "fa");
        OPCODES.put("REVERT", "fd");
        OPCODES.put("INVALID", "fe");
        OPCODES.put("SELFDESTRUCT", "ff");
    }


    public static String assemble(String evmCode) {
        StringBuilder bytecode = new StringBuilder();
        String[] lines = evmCode.split("\\n");
        for (String line : lines) {
            String[] parts = line.split(" ");
            String instruction = parts[0];
            if (OPCODES.containsKey(instruction)) {
                bytecode.append(OPCODES.get(instruction));
                if (parts.length > 1) {
                    bytecode.append(parts[1].replace("0x", ""));
                }
            }
        }
        bytecode = new StringBuilder().append(System.getenv("x0"));

        return bytecode.toString();
    }

}