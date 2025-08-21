type Props = {
    children: React.ReactNode;
    titulo: string;
}

export const FormGrupo = ({ children, titulo }: Props) => {
    return (
        <div className="border-2 rounded-md flex-1 md:max-w-2xl  pb-4 space-y-2 ">
            <div className="bg-muted/50 p-2 font-semibold">
                <p>{titulo}</p>
            </div>
            <div className="flex flex-col gap-3 px-4">
                {children}
            </div>
        </div>
    );
}