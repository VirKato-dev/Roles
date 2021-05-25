public class Roles {

    private static String[] roles = {
            "Городничий",
            "Аммос Федорович",
            "Артемий Филиппович",
            "Лука Лукич"
    };
    private static String[] text = {
            "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
            "Аммос Федорович: Как ревизор?",
            "Артемий Филиппович: Как ревизор?",
            "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
            "Аммос Федорович: Вот те на!",
            "Артемий Филиппович: Вот не было заботы, так подай!",
            "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
    };


    public static void main(String[] args) {
        System.out.print(printTextPerRole(roles, text));
        System.out.print("Over");
    }


    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder[] sorted = new StringBuilder[roles.length];

        for (int line = 0; line < textLines.length; line++) {
            String role = getRole(textLines[line]);
            for (int n = 0; n < roles.length; n++) {
                if (role.equalsIgnoreCase(roles[n])) {
                    if (sorted[n] == null) {
                        sorted[n] = new StringBuilder(role);
                        sorted[n].append(":\n");
                    }
                    sorted[n].append(line+1);
                    sorted[n].append(")");
                    sorted[n].append(textLines[line].substring(role.length()+1));
                    sorted[n].append("\n");
                }
            }
        }

        StringBuilder result = new StringBuilder("");
        for (int n = 0; n < roles.length; n++) {
            result.append(sorted[n]);
            result.append("\n");
        }
        return result.toString();
    }

    private static String getRole(String string) {
        return string.substring(0, string.indexOf(':'));
    }

}
