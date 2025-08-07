import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { InformacaoPessoal } from "./informacao-pessoal";
import { ComplementoDados } from "./complemento-dados";

export const CartaoPessoa = () => {
    return (
        <Card>
            <CardHeader>
                <CardTitle className="text-xl">Informações da pessoa</CardTitle>
            </CardHeader> 
            <CardContent className="lg:flex gap-5 justify-between">
                <InformacaoPessoal/>
                <ComplementoDados/>
            </CardContent>
        </Card>
        
    );
}
